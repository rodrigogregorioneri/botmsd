
package neri.rodrigo.botmsd.model.assistent;

import java.util.List;


public class ResponseAssistent {


    private Boolean expectUserResponse;

    private List<ExpectedInput> expectedInputs;



    public Boolean getExpectUserResponse() {
        return expectUserResponse;
    }

    public void setExpectUserResponse(Boolean expectUserResponse) {
        this.expectUserResponse = expectUserResponse;
    }

    public List<ExpectedInput> getExpectedInputs() {
        return expectedInputs;
    }

    public void setExpectedInputs(List<ExpectedInput> expectedInputs) {
        this.expectedInputs = expectedInputs;
    }

}
