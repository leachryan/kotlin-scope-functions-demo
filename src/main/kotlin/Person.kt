data class Person(
    var name: String,
    var age: Int,
    var occupation: String,
    var location: String
) {
    fun changeName(name: String): Person {
        this.name = name
        return this
    }

    fun haveBirthday(): Person {
        this.age++
        return this
    }

    fun acceptNewJob(occupation: String): Person {
        this.occupation = occupation
        return this
    }

    fun getPersonSummary(): String = "Summary - Name: ${name}, Age: ${age}, Occupation: ${occupation}, Location: ${location}"

    fun relocate(location: String): Person {
        this.location = location
        return this
    }
}