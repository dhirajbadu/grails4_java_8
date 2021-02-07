package java_8

import com.ClientDTO
import com.ClientWrapper

import java.util.stream.Collectors

class ParallelStreamApiService {

    def serviceMethod() {

    }

    private def convertToClientWrapper(ClientDTO clientDTO){
        if (clientDTO == null){
            return null;
        }

        return new ClientWrapper(clientDTO.id , clientDTO.firstName + " " + clientDTO.lastName)
    }

    /**
     * Parallelly map the objects
     * */
    def streamMapExample(List<ClientDTO> clientDTOList){
        clientDTOList.parallelStream().map{convertToClientWrapper(it)}.collect(Collectors.toList())
    }

    /**
     * Parallelly filters the objects
     * */
    def streamFilterExample(List<ClientDTO> clientDTOList){
        clientDTOList.parallelStream()().filter{it.firstName == "Dhiraj"}.collect(Collectors.toList())
    }

    /**
     * Parallelly match the objects
     * anyMatch return true if any one object is matched from the list
     * */
    def streamAnyMatchExample(List<ClientDTO> clientDTOList , String match){
        return clientDTOList.parallelStream()().anyMatch{(it.firstName.contains(match))}
    }

    /**
     * Parallelly match the objects
     * anyMatch return true if all the objects are matched from the list
     * */
    def streamAllMatchExample(List<ClientDTO> clientDTOList , String match){
        clientDTOList.parallelStream()().allMatch{it.firstName.contains(match)}
    }

    def streamPaginationExample(List<ClientDTO> clientDTOList , int offset , int max){
        clientDTOList.parallelStream()().skip(offset).limit(max).collect(Collectors.toList())
    }

}
