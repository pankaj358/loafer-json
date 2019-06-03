package devloafer.projects.code.jsonify.util;

public interface LoaferHeaderFieldSeparatorConstant
{
  public String SEPARATE_BY_PIPE = "|";
  public String SEPARATE_BY_COMMA = ",";
  public String SEPARATE_BY_COLON=":";
  public String DEVLOAFER_MODEL_NAME = "DevloaferModel";
  public String DATA_MEMBER_DECLARATION = " private String %s;";
  public String MEMBER_GETTER_DECLARATION = " public %s get%s(){ return this.%s; }";
  public String MEMBER_SETTER_DECLARATION = " public void set%s(String %s) { this.%s = %s;}";
  public String IMPORT_STATEMENT_LOAFER_JSON = "import devloafer.projects.code.jsonify.LoaferJsonInterface";
  public String IMPLEMENTS_LOAFER_JSON = " implements LoaferJsonInterface ";
  public String DEVLOAFER_CLASS_DECLARATION = String.format("public class %s { ", IMPLEMENTS_LOAFER_JSON);
  public String GENERATED_CLASS_PACKAGE  = "package devloafer.projects.code.jsonify.generated";  
}
