package java_8

import grails.testing.mixin.integration.Integration
import grails.testing.services.ServiceUnitTest
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
class ParallelStreamVSStreamApiServiceSpec extends Specification implements ServiceUnitTest<ParallelStreamVSStreamApiService>{

    @Autowired
    private ParallelStreamVSStreamApiService parallelStreamVSStreamApiService
    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    void "test difference"(){
        List list = [1, 2, 3 , 4 , 5,  6, 7 , 8, 9 , 10]
        parallelStreamVSStreamApiService.streamApiLoop(list)
        parallelStreamVSStreamApiService.parallelStreamApiLoop(list)
        expect:
        true
    }
}
