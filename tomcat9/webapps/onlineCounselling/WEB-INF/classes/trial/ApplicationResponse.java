import java.util.*;

import java.io.*;
public class ApplicationResponse implements Serializable
{
//public boolean isSuccess=false;
//public boolean isException=false;
//public String exception="";
//public String error="";
public String name;
//public Object arr;
public ArrayList<ADTO> arr;
public String getABC()
{
return this.name;
}
public ArrayList<ADTO> getObj()
{
return this.arr;
}
}