package com.wipro.facts.ui.login;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.wipro.facts.data.DataManager;
import com.wipro.facts.data.remote.FactsOutputModel;
import com.wipro.facts.data.remote.RowsItem;
import com.wipro.facts.ui.home.canada.FactsNavigator;
import com.wipro.facts.ui.home.canada.FactsViewModel;
import com.wipro.facts.utils.rx.RxImmediateSchedulerRule;
import com.wipro.facts.utils.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import io.reactivex.Single;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class FactsViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =
            new InstantTaskExecutorRule();
    @Rule
    public RxImmediateSchedulerRule rxImmediateSchedulerRule =
            new RxImmediateSchedulerRule();
    @Mock
    FactsNavigator factsNavigator;
    @Mock
    DataManager dataManager;
    private FactsViewModel factsViewModel;
    private TestScheduler testScheduler;

    @BeforeClass
    public static void onlyOnce() {
        //Empty
    }

    @Before
    public void setUp() {
        testScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(testScheduler);
        factsViewModel = new FactsViewModel(dataManager, testSchedulerProvider);
        factsViewModel.setNavigator(factsNavigator);
    }

    @After
    public void tearDown() {
        testScheduler = null;
        factsViewModel = null;
        factsNavigator = null;
    }


    @Test
    public void testListEmptyData() {
        FactsOutputModel factsOutputModel = new FactsOutputModel("Test", new ArrayList<>());
        doReturn(Single.just(factsOutputModel))
                .when(dataManager)
                .getCanadaApiCall();
        factsViewModel.fetchCanadaRows();
        testScheduler.triggerActions();
        Assert.assertEquals(factsOutputModel.getRows(), factsViewModel.getRowsItemLiveData().getValue());
    }

    @Test
    public void testListContainData() {
        ArrayList<RowsItem> items = new ArrayList<>();
        RowsItem rowsItemFact1 = new RowsItem();
        rowsItemFact1.setTitle("Test1");
        rowsItemFact1.setDescription("Test1");
        rowsItemFact1.setImageHref("Test1");

        RowsItem rowsItemFact2 = new RowsItem();
        rowsItemFact2.setTitle("Test2");
        rowsItemFact2.setDescription("Test2");
        rowsItemFact2.setImageHref("Test2");

        items.add(rowsItemFact1);
        items.add(rowsItemFact2);
        FactsOutputModel factsOutputModel = new FactsOutputModel("Test", items);
        doReturn(Single.just(factsOutputModel))
                .when(dataManager)
                .getCanadaApiCall();
        factsViewModel.fetchCanadaRows();
        testScheduler.triggerActions();
        Assert.assertEquals(items, factsViewModel.getRowsItemLiveData().getValue());
    }

    @Test
    public void testTitleOfPage() {
        FactsOutputModel factsOutputModel = new FactsOutputModel("Test", new ArrayList<>());
        doReturn(Single.just(factsOutputModel))
                .when(dataManager)
                .getCanadaApiCall();
        factsViewModel.fetchCanadaRows();
        testScheduler.triggerActions();
        Assert.assertEquals(factsOutputModel.getTitle(), factsViewModel.getPageTitle().getValue());
    }


    @Test
    public void testErrorLoadingData() {
        Exception exception = new Exception("Test Error");
        doReturn(Single.error(exception))
                .when(dataManager)
                .getCanadaApiCall();
        factsViewModel.fetchCanadaRows();
        testScheduler.triggerActions();
        Assert.assertEquals(exception, factsViewModel.getError().getValue());
    }
}
