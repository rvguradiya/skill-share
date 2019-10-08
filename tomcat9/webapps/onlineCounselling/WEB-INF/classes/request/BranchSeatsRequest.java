package request;
import java.util.*;
import java.io.*;
import dto.*;

public class BranchSeatsRequest implements Serializable
{
private List<BranchSeatsDTO> branchSeats;
public List<BranchSeatsDTO> getBranchSeats()
{
return this.branchSeats;
}

}