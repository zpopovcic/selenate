package net.selenate.server
package actions
package workers

import extensions.SelenateFirefox

import net.selenate.common.comms.req.SeReqFindAndClick
import net.selenate.common.comms.res.SeResFindAndClick
import org.openqa.selenium.remote.RemoteWebElement

class FindAndClickAction(val sessionID: String, val d: SelenateFirefox)(implicit context: ActionContext)
    extends RetryableAction[SeReqFindAndClick, SeResFindAndClick]
    with ActionCommons {
  type PathElement = (FramePath, RemoteWebElement)

  def retryableAct = { arg =>
    val elementList: Stream[Boolean] =
      inAllWindows { address =>
        tryb {
          findElement(arg.method, arg.query).click
        }
      }

    val isElementClicked = elementList.contains(true)
    if (isElementClicked) {
      new SeResFindAndClick()
    } else {
      throw new IllegalArgumentException("Element [%s, %s] was not found in any frame!".format(arg.method.toString, arg.query))
    }
  }
}