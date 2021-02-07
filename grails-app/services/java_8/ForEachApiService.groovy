package java_8

import com.ClientDTO
import grails.gorm.transactions.Transactional

@Transactional
class ForEachApiService {

    def serviceMethod() {

    }

    private void printClient(ClientDTO clientDTO){
        println("--------------")
        println("Id : ${clientDTO.id}")
        println("First Name : ${clientDTO.firstName}")
        println("Last Name : ${clientDTO.lastName}")
    }

    def forEachLoopExample(List<ClientDTO> clientDTOList){
        println("-----Client Details------------")
        clientDTOList.parallelStream().forEach{printClient(it)}
    }

    def normalForLoopExample(List<ClientDTO> clientDTOList){
        println("-----Client Details------------")
        for (ClientDTO clientDTO : clientDTOList){
            printClient(clientDTO)
        }
    }
}
