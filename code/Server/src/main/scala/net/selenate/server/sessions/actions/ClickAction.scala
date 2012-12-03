package net.selenate
package server
package sessions
package actions

import common.comms.res._
import common.comms.req._

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.{ By, WebElement }

class ClickAction(val d: FirefoxDriver)
    extends IAction[SeReqClick, SeResClick]
    with ActionCommons {
  def act = { arg =>
    val e = findElement(arg.method, arg.selector)
    e.click

    new SeResClick()
  }
}