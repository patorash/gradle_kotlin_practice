package patorash.gradle_kotlin_practice

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

WebServlet("/servlet") class SampleServlet : HttpServlet() {
    class object {
        val serialVersionUID = 1L
    }

    override public fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        res.getWriter().println("war on jetty.");
    }
}