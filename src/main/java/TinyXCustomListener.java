import java.util.HashMap;

/**
 *
 * @author Shalitha Suranga
 */
public class TinyXCustomListener extends TinyXBaseListener {

	HashMap<String, Integer> variableMap = new HashMap();

	@Override
	public void exitShow(TinyXParser.ShowContext ctx) {
		if (ctx.INT() != null) {
			System.out.println(ctx.INT().getText());
		} else if (ctx.VAR() != null) {
			System.out.println(this.variableMap.get(ctx.VAR().getText()));
		}
	}

	@Override
	public void exitLet(TinyXParser.LetContext ctx) {
	 
	 	String variableName=ctx.VAR(0).getText();
	 	String value=(ctx.VAR().size()>1)?ctx.VAR(1).getText():ctx.INT().getText();
	 	
	 	if(ctx.VAR().size()>1)
	 	{
	 		this.variableMap.put(variableName,variableMap.get(value));
	 	}
	 	else
	 	{
	 		
		 	this.variableMap.put(variableName, Integer.parseInt(value));
	 	}
	}

}