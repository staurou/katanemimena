package ssn.models;

import java.util.Arrays;
import java.util.List;

public class RequestToMapper implements Cloneable {
    private long requestId;
    private int mappersCount;
    private LocationStatsRequest locationStatsRequest;
    private int mapperId;

    public RequestToMapper(long requestId, int mappersCount,
            LocationStatsRequest locationStatsRequest) {
        this.requestId = requestId;
        this.mappersCount = mappersCount;
        this.locationStatsRequest = locationStatsRequest;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public int getMappersCount() {
        return mappersCount;
    }

    public void setMappersCount(int mappersCount) {
        this.mappersCount = mappersCount;
    }

    public LocationStatsRequest getLocationStatsRequest() {
        return locationStatsRequest;
    }

    public void setLocationStatsRequest(LocationStatsRequest locationStatsRequest) {
        this.locationStatsRequest = locationStatsRequest;
    }

    public int getMapperId() {
        return mapperId;
    }

    public void setMapperId(int mapperId) {
        this.mapperId = mapperId;
    }
    
    
    public List<LocationStatsRequest> getMySubRequest() {
        LocationStatsRequest part = new LocationStatsRequest();
        part.setCaptureTimeFrom(locationStatsRequest.getCaptureTimeFrom());
        part.setCaptureTimeTo(locationStatsRequest.getCaptureTimeTo());
        part.setLongitudeFrom(locationStatsRequest.getLongitudeFrom());
        part.setLongitudeTo(locationStatsRequest.getLongitudeTo());
        
        double partWidth = (locationStatsRequest.getLatitudeTo()-locationStatsRequest.getLatitudeFrom())/ mappersCount;
        part.setLatitudeFrom(locationStatsRequest.getLatitudeFrom() + partWidth*mapperId);
        part.setLatitudeTo(part.getLatitudeFrom() + partWidth);
        
        return Arrays.asList(part);
    }
}