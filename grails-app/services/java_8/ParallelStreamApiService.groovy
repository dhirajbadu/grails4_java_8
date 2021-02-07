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

    def streamMapExample(List<ClientDTO> clientDTOList){
        clientDTOList.parallelStream().map{convertToClientWrapper(it)}.collect(Collectors.toList())
    }

    def streamFilterExample(List<ClientDTO> clientDTOList){
        clientDTOList.parallelStream()().filter{it.firstName == "Dhiraj"}.collect(Collectors.toList())
    }

    def streamAnyMatchExample(List<ClientDTO> clientDTOList , String match){
        return clientDTOList.parallelStream()().anyMatch{(it.firstName.contains(match))}
    }

    def streamAllMatchExample(List<ClientDTO> clientDTOList , String match){
        clientDTOList.parallelStream()().allMatch{it.firstName.contains(match)}
    }

    def streamPaginationExample(List<ClientDTO> clientDTOList , int offset , int max){
        clientDTOList.parallelStream()().skip(offset).limit(max).collect(Collectors.toList())
    }

}
