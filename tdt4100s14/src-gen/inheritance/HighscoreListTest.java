package inheritance;

import inheritance.HighscoreList;
import inheritance.TestListener;
import java.util.List;
import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;

@JExercise(description = "Tests inheritance.HighscoreList")
@SuppressWarnings("all")
public class HighscoreListTest extends TestCase {
  private HighscoreList sub;
  
  private HighscoreList _init_sub() {
    HighscoreList _highscoreList = new HighscoreList(2);
    return _highscoreList;
  }
  
  private TestListener l1;
  
  private TestListener _init_l1() {
    TestListener _testListener = new TestListener(this.sub);
    return _testListener;
  }
  
  private TestListener l2;
  
  private TestListener _init_l2() {
    TestListener _testListener = new TestListener(this.sub);
    return _testListener;
  }
  
  @Override
  protected void setUp() {
    sub = _init_sub();
    l1 = _init_l1();
    l2 = _init_l2();
    
  }
  
  @JExercise(tests = "HighscoreList(int);void addItem(Comparable)", description = "<h3>Tester \u00E5 legge til nye elementer i listen</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Legger til f\u00F8rste resultat: sub.addItem(5)</li>\n\t\t<li>Legger til siste resultat: sub.addItem(3)</li>\n\t\t<li>Legger til bedre resultat: sub.addItem(2)</li>\n\t\t</ul>\n")
  public void testAddItem() {
    _transition_exprAction__addItem_transitions0_actions0();
    _test__addItem_transitions0_effect_state();
    _transition_exprAction__addItem_transitions1_actions0();
    _test__addItem_transitions1_effect_state();
    _transition_exprAction__addItem_transitions2_actions0();
    _test__addItem_transitions2_effect_state();
    
  }
  
  @JExercise(tests = "HighscoreList(int);void addItem(Comparable)", description = "<h3>Tester \u00E5 legge til, fjerne og oppdatere observat\u00F8rer</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Legger til observat\u00F8rer og endrer liste: sub.addListListener(l1), sub.addListListener(l2), sub.addItem(3)</li>\n\t\t<li>Fjerner observat\u00F8r og endrer liste: sub.removeListListener(l1), sub.addItem(1)</li>\n\t\t</ul>\n")
  public void testListListeners() {
    _transition_exprAction__listListeners_transitions0_actions0();
    _transition_exprAction__listListeners_transitions0_actions1();
    _transition_exprAction__listListeners_transitions0_actions2();
    _test__listListeners_transitions0_effect_state();
    _transition_exprAction__listListeners_transitions1_actions0();
    _transition_exprAction__listListeners_transitions1_actions1();
    _test__listListeners_transitions1_effect_state();
    
  }
  
  private void _transition_exprAction__addItem_transitions0_actions0() {
    try {
      
      this.sub.addItem(Integer.valueOf(5));
      } catch (junit.framework.AssertionFailedError error) {
      fail("sub.addItem(5) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__addItem_transitions0_effect_state() {
    _test__addItem_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__addItem_transitions0_effect_state_objectTests0_test() {
    
    List<Comparable> _list = this.sub.getList();
    Comparable _get = _list.get(0);
    assertEquals("sub.list.get(0) == 5 failed after sub.addItem(5)", Integer.valueOf(5), _get);
    
  }
  
  private void _transition_exprAction__addItem_transitions1_actions0() {
    try {
      
      this.sub.addItem(Integer.valueOf(3));
      } catch (junit.framework.AssertionFailedError error) {
      fail("sub.addItem(3) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__addItem_transitions1_effect_state() {
    _test__addItem_transitions1_effect_state_objectTests0_test();
    
  }
  
  private void _test__addItem_transitions1_effect_state_objectTests0_test() {
    
    List<Comparable> _list = this.sub.getList();
    Comparable _get = _list.get(0);
    assertEquals("sub.list.get(0) == 3 failed after sub.addItem(3)", Integer.valueOf(3), _get);
    
    List<Comparable> _list_1 = this.sub.getList();
    Comparable _get_1 = _list_1.get(1);
    assertEquals("sub.list.get(1) == 5 failed after sub.addItem(3)", Integer.valueOf(5), _get_1);
    
  }
  
  private void _transition_exprAction__addItem_transitions2_actions0() {
    try {
      
      this.sub.addItem(Integer.valueOf(2));
      } catch (junit.framework.AssertionFailedError error) {
      fail("sub.addItem(2) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__addItem_transitions2_effect_state() {
    _test__addItem_transitions2_effect_state_objectTests0_test();
    
  }
  
  private void _test__addItem_transitions2_effect_state_objectTests0_test() {
    
    List<Comparable> _list = this.sub.getList();
    Comparable _get = _list.get(0);
    assertEquals("sub.list.get(0) == 2 failed after sub.addItem(2)", Integer.valueOf(2), _get);
    
    List<Comparable> _list_1 = this.sub.getList();
    Comparable _get_1 = _list_1.get(1);
    assertEquals("sub.list.get(1) == 3 failed after sub.addItem(2)", Integer.valueOf(3), _get_1);
    
  }
  
  private void _transition_exprAction__listListeners_transitions0_actions0() {
    try {
      
      this.sub.addListListener(this.l1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("sub.addListListener(l1) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__listListeners_transitions0_actions1() {
    try {
      
      this.sub.addListListener(this.l2);
      } catch (junit.framework.AssertionFailedError error) {
      fail("sub.addListListener(l2) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__listListeners_transitions0_actions2() {
    try {
      
      this.sub.addItem(Integer.valueOf(3));
      } catch (junit.framework.AssertionFailedError error) {
      fail("sub.addItem(3) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__listListeners_transitions0_effect_state() {
    _test__listListeners_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__listListeners_transitions0_effect_state_objectTests0_test() {
    
    List _list = this.l1.getList();
    Object _get = _list.get(0);
    assertEquals("l1.list.get(0) == 3 failed after sub.addListListener(l1) ,sub.addListListener(l2) ,sub.addItem(3)", Integer.valueOf(3), _get);
    
    List _list_1 = this.l2.getList();
    Object _get_1 = _list_1.get(0);
    assertEquals("l2.list.get(0) == 3 failed after sub.addListListener(l1) ,sub.addListListener(l2) ,sub.addItem(3)", Integer.valueOf(3), _get_1);
    
  }
  
  private void _transition_exprAction__listListeners_transitions1_actions0() {
    try {
      
      this.sub.removeListListener(this.l1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("sub.removeListListener(l1) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__listListeners_transitions1_actions1() {
    try {
      
      this.sub.addItem(Integer.valueOf(1));
      } catch (junit.framework.AssertionFailedError error) {
      fail("sub.addItem(1) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__listListeners_transitions1_effect_state() {
    _test__listListeners_transitions1_effect_state_objectTests0_test();
    
  }
  
  private void _test__listListeners_transitions1_effect_state_objectTests0_test() {
    
    List _list = this.l1.getList();
    Object _get = _list.get(0);
    assertEquals("l1.list.get(0) == 3 failed after sub.removeListListener(l1) ,sub.addItem(1)", Integer.valueOf(3), _get);
    
    List _list_1 = this.l1.getList();
    int _size = _list_1.size();
    assertEquals("l1.list.size() == 1 failed after sub.removeListListener(l1) ,sub.addItem(1)", 1, _size);
    
    List _list_2 = this.l2.getList();
    Object _get_1 = _list_2.get(0);
    assertEquals("l2.list.get(0) == 1 failed after sub.removeListListener(l1) ,sub.addItem(1)", Integer.valueOf(1), _get_1);
    
    List _list_3 = this.l2.getList();
    int _size_1 = _list_3.size();
    assertEquals("l2.list.size() == 2 failed after sub.removeListListener(l1) ,sub.addItem(1)", 2, _size_1);
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(HighscoreListTest.class);
  }
}
