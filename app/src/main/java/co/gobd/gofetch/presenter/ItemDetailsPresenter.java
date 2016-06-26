package co.gobd.gofetch.presenter;

import co.gobd.gofetch.ui.view.ItemDetailsView;
import java.lang.ref.WeakReference;

/**
 * Created by tonmoy on 15-Jun-16.
 */
public class ItemDetailsPresenter {

  private WeakReference<ItemDetailsView> weakItemDetailsView;
  private ItemDetailsView itemDetailsView;

  public void initialise(ItemDetailsView view) {
    this.weakItemDetailsView = new WeakReference<ItemDetailsView>(view);
    itemDetailsView = weakItemDetailsView.get();
  }

  public void addItem() {
    String itemName = itemDetailsView.getItemName();
    int itemQuantity = itemDetailsView.getItemQuantity();
  }
}
