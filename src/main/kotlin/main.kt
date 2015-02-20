package patorash.gradle_kotlin_practice

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.Request
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

fun main(args: Array<String>) {
    // 単純に全てのアクセスをHelloJettyHandlerに丸投げする
    val server = Server(1234)
    server.setHandler(HelloJettyHandler())
    server.start()
    server.join()
}

class HelloJettyHandler : AbstractHandler() {
    override fun handle(target: String?, baseRequest: Request?, request: HttpServletRequest?, response: HttpServletResponse?) {
        System.out.println("target = " + target)

        response!!.setContentType("text/html;charset=utf-8")
        response.setStatus(HttpServletResponse.SC_OK)
        baseRequest!!.setHandled(true)
        response.getWriter().println("<h1>Hello Jetty!!</h1>")
    }
}
