package com.easy.kotlin

class Project

interface ProjectService {
    var name: String
    var owner: String
    fun save(project: Project): Project
    fun print() {
        println("P")
    }
}


interface MilestoneService {
    fun getMilestone()
    fun print() {
        println("PPP")
    }
}

class ProjectServiceImpl(override var name: String, override var owner: String) : ProjectService, MilestoneService {
    override fun print() {
//        super.print()
        super<ProjectService>.print()
    }

    override fun getMilestone() {
        println("M")
    }

    override fun save(project: Project): Project {
        return Project()
    }
}

fun main(args: Array<String>) {
//    val projectService = ProjectService()
    val projectServiceImpl = ProjectServiceImpl("Kotlin Project", "Jack")
    println(projectServiceImpl is ProjectService)
    projectServiceImpl.save(Project())
    projectServiceImpl.print()
    projectServiceImpl.getMilestone()
}
