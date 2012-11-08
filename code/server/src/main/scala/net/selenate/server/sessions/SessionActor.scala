package net.selenate.server
package sessions

import comms.req._
import comms.res._

import akka.actor.{ Actor, ActorRef }

import org.openqa.selenium.firefox.{ FirefoxDriver, FirefoxProfile }
import org.openqa.selenium.OutputType

class SessionActor(sessionID: String, profile: FirefoxProfile) extends Actor {
  private val d = new FirefoxDriver(profile)

  private def p(s: String) {
    println("SESSION [%s] RECEIVED %s".format(sessionID, s))
  }


  private def tryOrReport[T](sender: ActorRef) =
    tryOrElse[Exception, T] { e =>
      println(e.toString)
      sender ! e
      e
    }

  def receive = {
    case "ping" => tryOrReport(sender) {
      p("PING FROM: "+ sender.path.toString)
    }
    case x: SeReqCapture => tryOrReport(sender) {
      p("CAPTURE")
      val html   = d.getPageSource()
      val screen = d.getScreenshotAs(OutputType.BYTES)
      sender ! new SeResCapture(html, screen)
    }
    case x: SeReqClick => tryOrReport(sender) {
      p("CLICK: "+ x.xpath)
      d.findElementByXPath(x.xpath).click()
    }
    case x: SeReqClose => tryOrReport(sender) {
      p("CLOSE")
      d.close()
    }
    case x: SeReqGet => tryOrReport(sender) {
      p("GET: "+ x.url)
      d.get(x.url)
    }
    case x => tryOrReport(sender) {
      println("UNKNOWN MESSAGE: "+ x.toString)
    }
  }
}