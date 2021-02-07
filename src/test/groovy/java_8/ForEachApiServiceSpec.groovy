package java_8

import com.ClientDTO
import grails.testing.mixin.integration.Integration
import grails.testing.services.ServiceUnitTest
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
class ForEachApiServiceSpec extends Specification implements ServiceUnitTest<ForEachApiService>{

    @Autowired
    private ForEachApiService forEachApiService;

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    void "test forEachLoopExample"(){
        List<ClientDTO> clientDTOList = new ArrayList<>();
        clientDTOList.add(new ClientDTO(1, "Dhiraj" , "Badu"))
        clientDTOList.add(new ClientDTO(2, "Suresh" , "Ghatuwa"))
        clientDTOList.add(new ClientDTO(3, "Sashank" , "Sakya"))
        clientDTOList.add(new ClientDTO(4, "Astha" , "Thapa"))
        clientDTOList.add(new ClientDTO(5, "Raksha" , "Manandhar"))

        forEachApiService.forEachLoopExample(clientDTOList)
        expect:
            true
    }

    void "test normalForLoopExample"(){
        List<ClientDTO> clientDTOList = new ArrayList<>();
        clientDTOList.add(new ClientDTO(1, "Dhiraj" , "Badu"))
        clientDTOList.add(new ClientDTO(2, "Suresh" , "Ghatuwa"))
        clientDTOList.add(new ClientDTO(3, "Sashank" , "Sakya"))
        clientDTOList.add(new ClientDTO(4, "Astha" , "Thapa"))
        clientDTOList.add(new ClientDTO(5, "Raksha" , "Manandhar"))

        forEachApiService.normalForLoopExample(clientDTOList)
        expect:
        true
    }
}
