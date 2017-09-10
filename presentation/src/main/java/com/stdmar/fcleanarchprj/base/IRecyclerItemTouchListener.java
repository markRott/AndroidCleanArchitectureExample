package com.stdmar.fcleanarchprj.base;

/**
 * Created by sma on 10.09.17.
 */

public interface IRecyclerItemTouchListener<Item> {

    void onTouch(int position, Item data);
}
