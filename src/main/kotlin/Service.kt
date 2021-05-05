class Service(var url: String, var port: Int) {
    fun getResponse(): Response = Response("", 200)
}