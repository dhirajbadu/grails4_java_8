package java_8

import com.ClientDTO
import com.ClientWrapper
import grails.converters.JSON
import grails.testing.mixin.integration.Integration
import grails.testing.services.ServiceUnitTest
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
class StreamApiServiceSpec extends Specification implements ServiceUnitTest<StreamApiService>{

    @Autowired
    private StreamApiService streamApiService;

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    void "test streamMapExample"(){
        List<ClientDTO> clientDTOList = new ArrayList<>();
        clientDTOList.add(new ClientDTO(1, "Dhiraj" , "Badu"))
        clientDTOList.add(new ClientDTO(1, "Suresh" , "Ghatuwa"))
        clientDTOList.add(new ClientDTO(1, "Sashank" , "Sakya"))
        List<ClientWrapper> clientWrapperList =  streamApiService.streamMapExample(clientDTOList)
        println(clientWrapperList as JSON)
        expect:
            clientWrapperList.size() == clientDTOList.size()
    }

    void "test streamFilterExample"(){
        List<ClientDTO> clientDTOList = new ArrayList<>();
        clientDTOList.add(new ClientDTO(1, "Dhiraj" , "Badu"))
        clientDTOList.add(new ClientDTO(1, "Suresh" , "Ghatuwa"))
        clientDTOList.add(new ClientDTO(1, "Sashank" , "Sakya"))
        List<ClientWrapper> clientWrapperList =  streamApiService.streamFilterExample(clientDTOList)
        println(clientWrapperList as JSON)
        expect:
        clientWrapperList.size() == 1
    }

    void "test streamAnyMatchExample"(){
        List<ClientDTO> clientDTOList = new ArrayList<>();
        clientDTOList.add(new ClientDTO(1, "Dhiraj" , "Badu"))
        clientDTOList.add(new ClientDTO(1, "Suresh" , "Ghatuwa"))
        clientDTOList.add(new ClientDTO(1, "Sashank" , "Sakya"))
        boolean  isMatched = streamApiService.streamAnyMatchExample(clientDTOList , "s")
        expect:
        isMatched
    }

    void "test streamAllMatchExample"(){
        List<ClientDTO> clientDTOList = new ArrayList<>();
        clientDTOList.add(new ClientDTO(1, "Dhiraj" , "Badu"))
        clientDTOList.add(new ClientDTO(1, "Suresh" , "Ghatuwa"))
        clientDTOList.add(new ClientDTO(1, "Sashank" , "Sakya"))
        boolean  isMatched = streamApiService.streamAllMatchExample(clientDTOList , "s")
        expect:
        !isMatched
    }

    void "test streamPaginationExample"(){
        List<ClientDTO> clientDTOList = new ArrayList<>();
        clientDTOList.add(new ClientDTO(1, "Dhiraj" , "Badu"))
        clientDTOList.add(new ClientDTO(1, "Suresh" , "Ghatuwa"))
        clientDTOList.add(new ClientDTO(1, "Sashank" , "Sakya"))
        List<ClientWrapper> clientWrapperList = streamApiService.streamPaginationExample(clientDTOList , 1 , 3)
        println(clientWrapperList as JSON)
        expect:
        clientWrapperList.size() == 2
    }
}
