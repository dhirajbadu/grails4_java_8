package java_8

import com.ClientDTO
import com.ClientWrapper
import grails.gorm.transactions.Transactional

import java.util.stream.Collectors

class StreamApiService {

    def serviceMethod() {

    }

    private def convertToClientWrapper(ClientDTO clientDTO){
        if (clientDTO == null){
            return null;
        }

        return new ClientWrapper(clientDTO.id , clientDTO.firstName + " " + clientDTO.lastName)
    }

    def streamMapExample(List<ClientDTO> clientDTOList){
        clientDTOList.stream().map{convertToClientWrapper(it)}.collect(Collectors.toList())
    }

    def streamFilterExample(List<ClientDTO> clientDTOList){
        clientDTOList.stream().filter{it.firstName == "Dhiraj"}.collect(Collectors.toList())
    }

    /**
     * anyMatch return true if any one object is matched from the list
     * */
    def streamAnyMatchExample(List<ClientDTO> clientDTOList , String match){
        return clientDTOList.stream().anyMatch{(it.firstName.contains(match))}
    }

    /**
     * anyMatch return true if all the objects are matched from the list
     * */
    def streamAllMatchExample(List<ClientDTO> clientDTOList , String match){
        clientDTOList.stream().allMatch{it.firstName.contains(match)}
    }

    def streamPaginationExample(List<ClientDTO> clientDTOList , int offset , int max){
        clientDTOList.stream().skip(offset).limit(max).collect(Collectors.toList())
    }

}
