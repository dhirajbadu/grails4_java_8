package java_8

import com.ClientDTO
import grails.gorm.transactions.Transactional

import java.util.function.Consumer

@Transactional
class LambdaExpressionsApiService {

    def serviceMethod() {

    }

    private void printClient(ClientDTO clientDTO){
        println("--------------")
        println("Id : ${clientDTO.id}")
        println("First Name : ${clientDTO.firstName}")
        println("Last Name : ${clientDTO.lastName}")
    }


    def lambdaExample(List<ClientDTO> clientDTOList){
        println("-----Client Details------------")
        clientDTOList.parallelStream().forEach{client -> printClient(client)}
    }
}
