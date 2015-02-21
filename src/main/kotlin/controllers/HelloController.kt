package patorash.gradle_kotlin_practice.controllers

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.annotation.WebServlet

WebServlet(name = "Hello", value = array("/hello"))
class HelloController : HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.getWriter()?.write("Hello, World!")
    }
}