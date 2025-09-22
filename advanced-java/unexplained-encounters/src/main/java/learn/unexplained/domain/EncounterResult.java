package learn.unexplained.domain;

import learn.unexplained.models.Encounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EncounterResult {
    private Encounter payload;
    private final List<String> messages = new ArrayList<>();

    public boolean isSuccess() {
        return messages.isEmpty();
    }

    public void addErrorMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }

    public Encounter getPayload() {
        return payload;
    }

    public void setPayload(Encounter payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EncounterResult)) return false;
        EncounterResult that = (EncounterResult) o;
        // Compare messages (order matters) and payload
        return Objects.equals(messages, that.messages)
                && Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messages, payload);
    }

    @Override
    public String toString() {
        return "EncounterResult{" +
                "success=" + isSuccess() +
                ", messages=" + messages +
                ", payload=" + payload +
                '}';
    }
}
