package nl.bestego.springclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.wsdl.GetPersoonRequest;
import com.example.consumingwebservice.wsdl.GetPersoonResponse;

public class PersoonClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(PersoonClient.class);

    public GetPersoonResponse getPersoon(Long id) {

        GetPersoonRequest request = new GetPersoonRequest();
        request.setId(id);

        log.info("Requesting location for " + id);

        GetPersoonResponse response = (GetPersoonResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8090/personenSoapWS", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetPersoonRequest"));

        return response;
    }

}
