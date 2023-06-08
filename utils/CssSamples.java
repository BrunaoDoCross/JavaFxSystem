package utils;


public class CssSamples {
	
	public static String animaMouseIn(double xPorcentagemDeAumento, double yPorcentagemDeAumento) {
	return 	  (" -fx-scale-x: "+(1+(xPorcentagemDeAumento/100))+";\r\n" 
				+ "	-fx-scale-y: "+(1+(yPorcentagemDeAumento/100))+";");
	}
	
	public static final String animaMouseBack() {
		return 	  (" -fx-scale-x: 1.0;" + "\r\n" 
					+ "	-fx-scale-y: 1.0" + ";");
		}
	
}

//public static String animaMousePass(String backgroundColor, String textColor) {
//return"-fx-background-color: "+backgroundColor+";\r\n"
//		+ "	-fx-text-fill: "+textColor+";";
//}	

//public static String animaMousePassGrow(String backgroundColor, String textColor, double xPorcentagemDeAumento, double yPorcentagemDeAumento) {
//return 	  ("	-fx-background-color: "+backgroundColor+";\r\n"
//		+ "	-fx-text-fill: "+textColor+";\r\n"
//		+ "	-fx-scale-x: "+(1+(xPorcentagemDeAumento/100))+";\r\n"
//		+ "	-fx-scale-y: "+(1+(yPorcentagemDeAumento/100))+";");
//}