package com.lindo.repositories.config.database.tables;

import java.util.ArrayList;

/**
 * Created by Lindo on 2016-10-31.
 */
public abstract class Table {
    protected abstract String getTableName();
    protected abstract Attribute getPrimaryKey();
    protected abstract ArrayList<Attribute> getAllAttributes();
}
