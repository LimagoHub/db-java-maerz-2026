package de.db.application;


import de.db.gui.Euro2DollarRechnerViewImpl;
import de.db.gui.Euro2DollarRechnerView;
import de.db.gui.presenter.Euro2DollarPresenterImpl;
import de.db.gui.presenter.Euro2DollarPresenter;
import de.db.model.Euro2DollarRechnerImpl;
import de.db.model.Euro2DollarRechner;
import de.db.model.ExchanceService;
import de.db.model.ExchanceServiceImpl;

public class Main {


	public static void main(String[] args) {
		ExchanceService exchangeservice = new ExchanceServiceImpl();
		Euro2DollarRechner model = new Euro2DollarRechnerImpl(exchangeservice);
		
		Euro2DollarPresenter presenter = new Euro2DollarPresenterImpl();
		
		Euro2DollarRechnerView view = new Euro2DollarRechnerViewImpl();
		
		
		presenter.setView(view);
		presenter.setModel(model);
		
		view.setPresenter(presenter);
		
		presenter.onPopulateItems();
		
		view.show();

	}

}
