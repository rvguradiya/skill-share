package response;
import java.util.*;
import java.io.*;
//this class is common for all type of response
public class ApplicationResponse implements Serializable
{
public boolean isException;
public boolean isError;
public boolean isSuccess;
public Object result;
public Object exceptions;
public String error;
public ApplicationResponse()
{
isSuccess=false;
isError=false;
isException=false;
result=null;
exceptions=null;
error="";
}
//we send array of result and exceptions that how many countries are added successfully and 
//how many countries are not added successfully because of occur of exceptions

}