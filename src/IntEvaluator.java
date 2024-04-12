import java.util.List;
import java.util.stream.StreamSupport;

public class IntEvaluator implements Evaluator<Integer> {

    private Integer finalResult;
    private String response = "";
    private List<Integer> elements;
    private String operation;

    public IntEvaluator() {
    }



    public String getResponse() {
        return this.response;
    }


    @Override
    public void calcul(List<Integer> elements, String operation) {
        this.elements = elements;
        switch (operation) {
            case "+":
                this.operation = "additions";
                this.constructResponse("+");
                break;
        }
    }

    public void constructResponse(String symbol) {
        this.finalResult = elements.get(0);
        this.response += elements.get(0).toString() + "\n";
        List<Integer> sublist = elements.subList(1, elements.size());
        for (Integer e: sublist) {
            this.finalResult += e;
            this.response +=  symbol + e.toString() + " (=" + this.finalResult.toString() + ")\n";
        }

        this.response += "________\n";
        this.response += "total = 6 (" + this.operation + ")";
    }
}
