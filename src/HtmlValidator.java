import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		Stack<HtmlTag> errores_Pila = new Stack<>();
		for (HtmlTag tag : tags) {

			if (tag.isSelfClosing()) {
				continue;

			} else if (tag.isOpenTag()) {
				errores_Pila.push(tag);

			} else if (!tag.isOpenTag()) {

				if (!errores_Pila.isEmpty()) {
					if (errores_Pila.peek().matches(tag)) {
						errores_Pila.pop();
					} else {
						return errores_Pila;
					}
				} else {
					return null;
				}
			}
		}
		return errores_Pila;
	}
}

