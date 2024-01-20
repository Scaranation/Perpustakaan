package modelgson;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.JsonArray;

public abstract class Abstract<T> {
    public abstract boolean cekFile();
    public abstract void setupFile();
    public abstract JsonArray convertListToJsonArray(ArrayList<T> list);
    public abstract ArrayList<T> convertJsonArrayToList(JsonArray jsonArray, Type type);
    public abstract void WriteToFile(ArrayList<T> list);
    public abstract ArrayList<T> readFromFile(Type type);



}