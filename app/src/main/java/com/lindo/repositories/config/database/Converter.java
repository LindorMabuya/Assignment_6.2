package com.lindo.repositories.config.database;

import com.lindo.repositories.config.database.tables.Attribute;

import java.util.ArrayList;

/**
 * Created by bishop v on 2016-10-31.
 */
public class Converter {
    /**
     * returns a full create table query
     * arguments table name and arraylist of
     * type attributes
     * author Lindo
     */
    public static String toCreateTableQuery(String tableName, ArrayList<Attribute> attributes) {
        String query = null;
        if ( !tableName.equals("")) {
            query = "CREATE TABLE " + tableName + "(" + attributes.get(0).name + " " + attributes.get(0).type +
                    " PRIMARY KEY, ";
            for ( int i = 1; i < attributes.size(); i++ ) {
                if ( i == attributes.size() - 1) {
                    query = query + attributes.get(i).name + " " + attributes.get(i).type;
                }

                else {
                    query = query + attributes.get(i).name + " " + attributes.get(i).type + ", ";
                }
            }
            query = query + ")";
        }
        return query;
    }

    public static String toSelectAllWhere(String tableName, Attribute targetColumn, String value)  {
        String query = null;
        if ( !tableName.equals("") && !targetColumn.equals("") && !value.equals("")) {
            query = "SELECT * FROM " + tableName + " WHERE " + targetColumn.name + " = " + value;
        }
        return query;
    }

    public static String toSelectAll(String tableName){
        String query = null;
        if ( !tableName.equals("")) {
            query = "SELECT * FROM " + tableName;
        }
        return query;
    }

    public static String toSelectWithJoin() {
        return "";
    }
}
