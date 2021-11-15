package assembly;

public class RESERVED_REGISTERS{
    public static String object_attributes_getter = "R0"; //used for objects
    public static String affectation = "R1";//used for all affectation put value to affect in R1 it will be put in the variable
    public static String operations_register = "R5"; //used for < > = <> || &&
    public static String operations_register_2 = "R6"; //used for + - * /
    public static String if_register = "R9"; //used to reckon if then or else must be handled
    public static String if_register_2 = "R8"; //used in if for variables conditions
    public static String stackPointer_register = "R15";
    public static String working_register = "R14";
    public static String basePointer_register = "R13";
    public static String heapPointer_register = "R12";
    public static String instance_register = "R11";
    public static String return_function = "R10";
}