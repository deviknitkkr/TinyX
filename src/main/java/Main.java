import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

	public static void main(String[] args) {
		try {
			CharStream input = (CharStream) new ANTLRFileStream("/storage/emulated/0/TinyX/src/main/TinyX/test.TinyX");
			TinyXLexer lexer = new TinyXLexer(input);
			TinyXParser parser = new TinyXParser(new CommonTokenStream(lexer));
			parser.addParseListener(new TinyXCustomListener());
			parser.program();
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}


	}
}