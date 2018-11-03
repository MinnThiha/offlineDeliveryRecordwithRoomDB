package net.mycompany.deliveryrecords.mvp.presenter;

import net.mycompany.deliveryrecords.Activity.CheckActivity;
import net.mycompany.deliveryrecords.local_db.Entity.Records;
import net.mycompany.deliveryrecords.mvp.contract.CheckContract;
import net.mycompany.deliveryrecords.mvp.model.CheckModel;

public class CheckPresenter implements CheckContract.CheckPresenter {
    CheckContract.CheckContractView view;
    CheckModel mdl;

    public CheckPresenter(CheckContract.CheckContractView view) {
        this.view = view;
        mdl=new CheckModel(view.getContext());
        displayRecordstoView();
    }


    @Override
    public void displayRecordstoView() {
        view.displayRecords(mdl.getAllRecord());
    }

    @Override
    public void deleteRecords(Records records) {
        mdl.deleteRecords(records);
    }
}
