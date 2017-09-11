package com.stdmar.domain.interactors;

import com.stdmar.domain.interactors.stubclasses.TestDisposableSubscriber;
import com.stdmar.domain.interactors.stubclasses.TestParams;
import com.stdmar.domain.interactors.stubclasses.UseCaseTestClass;
import com.stdmar.domain.interfaces.IPostExecutionThread;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import io.reactivex.schedulers.TestScheduler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by sma on 11.09.17.
 */

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class BaseUseCaseTest {

    private UseCaseTestClass useCase;
    private TestDisposableSubscriber<Object> testDisposableSubscriber;

    @Mock
    private IPostExecutionThread mockPostExecutionThread;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {

        this.useCase = new UseCaseTestClass(mockPostExecutionThread);
        this.testDisposableSubscriber = new TestDisposableSubscriber<>();

        given(mockPostExecutionThread.getScheduler())
                .willReturn(new TestScheduler());
    }

    @Test
    public void testBuildUseCaseObservableReturnCorrectResult() {
        useCase.execute(testDisposableSubscriber, TestParams.EMPTY);

        assertThat(testDisposableSubscriber.getValuesCount()).isZero();
    }

    @Test
    public void testSubscriptionWhenExecutingUseCase() {
        useCase.execute(testDisposableSubscriber, TestParams.EMPTY);
        useCase.dispose();

        assertThat(testDisposableSubscriber.isDisposed()).isTrue();
    }

    @Test
    public void testShouldFailWhenExecuteWithNullObserver() {
        expectedException.expect(NullPointerException.class);
        useCase.execute(null, TestParams.EMPTY);
    }

    @Test
    public void testWithNullParam() {
        useCase.execute(testDisposableSubscriber, null);
        assertThat(testDisposableSubscriber.getValuesCount()).isZero();
    }

    @Test
    public void testObserverNullAndParamNull() {
        expectedException.expect(NullPointerException.class);
        useCase.execute(null, null);
    }
}
