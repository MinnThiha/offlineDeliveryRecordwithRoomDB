package net.mycompany.deliveryrecords.mvp.presenter;

import net.mycompany.deliveryrecords.mvp.contract.CheckdateContract;
import net.mycompany.deliveryrecords.mvp.delecate.CheckByDateDelegate;
import net.mycompany.deliveryrecords.mvp.model.CheckByDateModel;

public class CheckByDatePresenter implements CheckdateContract.CheckdatePresenter {
    CheckdateContract.CheckDatecontractView view;
    CheckByDateModel cdml;
    String date;


    public CheckByDatePresenter(CheckdateContract.CheckDatecontractView view) {
        this.view = view;
        cdml=new CheckByDateModel(view.getContext());

    }

    @Override
    public void displayrecordbydateView(String date) {
     view.displaydateRecords(cdml.QueryBydate(date));
    }
}
