
package neri.rodrigo.botmsd.model.assistent;

import java.util.List;


public class ExpectedInput {

    private List<PossibleIntent> possibleIntents;

    private InputPrompt inputPrompt;

    public List<PossibleIntent> getPossibleIntents() {
        return possibleIntents;
    }

    public void setPossibleIntents(List<PossibleIntent> possibleIntents) {
        this.possibleIntents = possibleIntents;
    }

    public InputPrompt getInputPrompt() {
        return inputPrompt;
    }

    public void setInputPrompt(InputPrompt inputPrompt) {
        this.inputPrompt = inputPrompt;
    }

}
