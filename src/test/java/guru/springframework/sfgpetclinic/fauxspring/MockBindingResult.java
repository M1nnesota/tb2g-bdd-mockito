package guru.springframework.sfgpetclinic.fauxspring;

public class MockBindingResult implements BindingResult {

    private boolean hasErrors;

    public MockBindingResult(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    @Override
    public void rejectValue(String lastName, String notFound, String not_found) {
    }

    @Override
    public boolean hasErrors() {
        return hasErrors;
    }
}
