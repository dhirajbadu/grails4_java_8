package java_8

import com.ClientDTO
import grails.gorm.transactions.Transactional

@Transactional
class FunctionalInterfaceApiService {

    def serviceMethod() {

    }

    interface StringFunction {
        String run(String str);
    }

    public static void printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        println(result);
    }

    def stringFunctionExample(List<ClientDTO> clientDTOList){
        StringFunction ask = { s -> s + " ?" }
        StringFunction dot = { s -> s + "." }
        clientDTOList.stream().forEach{ client->
            println("-----ask------------")
            printFormatted(client.firstName, ask)
            println("-----dot------------")
            printFormatted(client.firstName, dot)
        }
    }
}
