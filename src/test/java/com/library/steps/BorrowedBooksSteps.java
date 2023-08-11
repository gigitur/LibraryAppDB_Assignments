package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BorrowedBooksSteps {


    DashBoardPage dashBoardPage = new DashBoardPage();
    LoginPage loginPage = new LoginPage();
    //us02
    @Given("the {string} on the home page")
    public void the_on_the_home_page(String user) {

       // i have to create an object bcz i neeed to use login method
        loginPage.login(user);
        BrowserUtil.waitFor(3);

    }
    String actualBorrowBook;
    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {

        actualBorrowBook = dashBoardPage.borrowedBooksNumber.getText();


    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        String query = "select count(*) from book_borrow\n" +
                "WHERE is_returned=0";
        DB_Util.runQuery(query);
        String expectedBorrowedBook = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(actualBorrowBook,expectedBorrowedBook);


    }

}
