package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.ResultTableOfTextBox;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private SelenideElement fullNameLocator = $("#userName");
    private SelenideElement userEmailLocator = $("#userEmail");
    private SelenideElement currentAddressLocator = $("#currentAddress");
    private SelenideElement permanentAddressLocator = $("#permanentAddress");
    private SelenideElement submitButtonLocator = $("#submit");
    private SelenideElement outputLocator = $("#output");

    private ResultTableOfTextBox resultTableOfTextBox = new ResultTableOfTextBox();



    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setFullName (String value)
    {
        fullNameLocator.setValue(value);
        return this;
    }
    public TextBoxPage setEmail (String value)
    {
        userEmailLocator.setValue(value);
        return this;
    }
    public TextBoxPage setCurrentAddress (String value)
    {
        currentAddressLocator.setValue(value);
        return this;
    }
    public TextBoxPage setPermanentAddress (String value)
    {
        permanentAddressLocator.setValue(value);
        return this;
    }
    public void pushSubmitButton()
    {
        submitButtonLocator.click();
    }
    public TextBoxPage checkResult(String value)
    {
        resultTableOfTextBox.checkResult(outputLocator, value);
        return this;
    }

}
