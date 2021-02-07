package java_8

import grails.gorm.transactions.Transactional

@Transactional
class ParallelStreamVSStreamApiService {

    def serviceMethod() {

    }

    def streamApiLoop(List<Integer> integerList){
        println("------------streamApiLoop Start--------------")
        integerList.stream().forEach {println(it)}
        println("------------streamApiLoop End--------------")
    }

    def parallelStreamApiLoop(List<Integer> integerList){
        println("------------parallelStreamApiLoop Start--------------")
        integerList.parallelStream().forEach {println(it)}
        println("------------parallelStreamApiLoop End--------------")
    }
}
