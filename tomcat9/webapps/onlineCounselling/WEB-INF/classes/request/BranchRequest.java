package request;
import java.util.*;
import java.io.*;
import dto.*;
//we take pointer of list because it can hold the address of both linkedlist as well as arraylist
//this class is used to parse the  json array into corrosponding dto array

public class BranchRequest implements Serializable
{
private List<BranchDTO> branches;
public List<BranchDTO> getBranches()
{
return this.branches;
}

}