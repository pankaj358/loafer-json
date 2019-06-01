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
  
}
