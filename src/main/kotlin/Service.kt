class Service(var url: String, var port: Int) {
    fun getResponse(): Response = Response("", 200)
}

fun changeDestination(service: Service, url: String) {
    service.url = url
}