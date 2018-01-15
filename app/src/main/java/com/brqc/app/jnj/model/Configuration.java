package com.brqc.app.jnj.model;

/**
 * Created by ajay on 1/5/2018.
 */

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Configuration implements Parcelable {

    @SerializedName("EnforcementAction")
    @Expose
    private List<EnforcementAction> enforcementAction = null;
    @SerializedName("FunctionalArea")
    @Expose
    private List<FunctionalArea> functionalArea = null;
    @SerializedName("HealthAuthority")
    @Expose
    private List<HealthAuthority> healthAuthority = null;
    @SerializedName("NotificationPreference")
    @Expose
    private List<NotificationPreference> notificationPreference = null;
    @SerializedName("Regions")
    @Expose
    private List<Region> regions = null;
    public final static Parcelable.Creator<Configuration> CREATOR = new Creator<Configuration>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Configuration createFromParcel(Parcel in) {
            return new Configuration(in);
        }

        public Configuration[] newArray(int size) {
            return (new Configuration[size]);
        }

    };

    public Configuration(Parcel in) {
        in.readList(this.enforcementAction, (EnforcementAction.class.getClassLoader()));
        in.readList(this.functionalArea, (FunctionalArea.class.getClassLoader()));
        in.readList(this.healthAuthority, (HealthAuthority.class.getClassLoader()));
        in.readList(this.notificationPreference, (NotificationPreference.class.getClassLoader()));
        in.readList(this.regions, (Region.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     */
    public Configuration() {
    }

    /**
     * @param notificationPreference
     * @param healthAuthority
     * @param regions
     * @param enforcementAction
     * @param functionalArea
     */
    public Configuration(List<EnforcementAction> enforcementAction, List<FunctionalArea> functionalArea, List<HealthAuthority> healthAuthority, List<NotificationPreference> notificationPreference, List<Region> regions) {
        super();
        this.enforcementAction = enforcementAction;
        this.functionalArea = functionalArea;
        this.healthAuthority = healthAuthority;
        this.notificationPreference = notificationPreference;
        this.regions = regions;
    }

    public List<EnforcementAction> getEnforcementAction() {
        return enforcementAction;
    }

    public void setEnforcementAction(List<EnforcementAction> enforcementAction) {
        this.enforcementAction = enforcementAction;
    }

    public List<FunctionalArea> getFunctionalArea() {
        return functionalArea;
    }

    public void setFunctionalArea(List<FunctionalArea> functionalArea) {
        this.functionalArea = functionalArea;
    }

    public List<HealthAuthority> getHealthAuthority() {
        return healthAuthority;
    }

    public void setHealthAuthority(List<HealthAuthority> healthAuthority) {
        this.healthAuthority = healthAuthority;
    }

    public List<NotificationPreference> getNotificationPreference() {
        return notificationPreference;
    }

    public void setNotificationPreference(List<NotificationPreference> notificationPreference) {
        this.notificationPreference = notificationPreference;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(enforcementAction);
        dest.writeList(functionalArea);
        dest.writeList(healthAuthority);
        dest.writeList(notificationPreference);
        dest.writeList(regions);
    }

    public int describeContents() {
        return 0;
    }


    public class EnforcementAction implements Parcelable {

        @SerializedName("EActionId")
        @Expose
        private Integer eActionId;
        @SerializedName("EActionValue")
        @Expose
        private String eActionValue;
        private boolean isSelected;
        public final  Parcelable.Creator<EnforcementAction> CREATOR = new Creator<EnforcementAction>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public EnforcementAction createFromParcel(Parcel in) {
                return new EnforcementAction(in);
            }

            public EnforcementAction[] newArray(int size) {
                return (new EnforcementAction[size]);
            }

        };

        protected EnforcementAction(Parcel in) {
            this.eActionId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.eActionValue = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public EnforcementAction() {
        }

        /**
         * @param eActionId
         * @param eActionValue
         */
        public EnforcementAction(Integer eActionId, String eActionValue) {
            super();
            this.eActionId = eActionId;
            this.eActionValue = eActionValue;
        }

        public Integer getEActionId() {
            return eActionId;
        }

        public void setEActionId(Integer eActionId) {
            this.eActionId = eActionId;
        }

        public String getEActionValue() {
            return eActionValue;
        }

        public void setEActionValue(String eActionValue) {
            this.eActionValue = eActionValue;
        }
        public void setSelected(boolean isSelected){ this.isSelected = isSelected;}

        public boolean getSelected(){ return isSelected;}

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(eActionId);
            dest.writeValue(eActionValue);
        }

        public int describeContents() {
            return 0;
        }

    }


    public class FunctionalArea implements Parcelable {

        @SerializedName("FAreaId")
        @Expose
        private Integer fAreaId;
        @SerializedName("FAreaValue")
        @Expose
        private String fAreaValue;
        private  boolean isSelected;
        public final Parcelable.Creator<FunctionalArea> CREATOR = new Creator<FunctionalArea>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public FunctionalArea createFromParcel(Parcel in) {
                return new FunctionalArea(in);
            }

            public FunctionalArea[] newArray(int size) {
                return (new FunctionalArea[size]);
            }

        };

        protected FunctionalArea(Parcel in) {
            this.fAreaId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.fAreaValue = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public FunctionalArea() {
        }

        /**
         * @param fAreaId
         * @param fAreaValue
         */
        public FunctionalArea(Integer fAreaId, String fAreaValue) {
            super();
            this.fAreaId = fAreaId;
            this.fAreaValue = fAreaValue;
        }

        public Integer getFAreaId() {
            return fAreaId;
        }

        public void setFAreaId(Integer fAreaId) {
            this.fAreaId = fAreaId;
        }

        public String getFAreaValue() {
            return fAreaValue;
        }

        public void setFAreaValue(String fAreaValue) {
            this.fAreaValue = fAreaValue;
        }
        public void setSelected(boolean isSelected){ this.isSelected = isSelected;}

        public boolean getSelected(){ return isSelected;}

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(fAreaId);
            dest.writeValue(fAreaValue);
        }

        public int describeContents() {
            return 0;
        }

    }


    public class HealthAuthority implements Parcelable {

        @SerializedName("HAuthorityId")
        @Expose
        private Integer hAuthorityId;
        @SerializedName("HAuthorityValue")
        @Expose
        private String hAuthorityValue;
        private boolean isSelected;
        public final Parcelable.Creator<HealthAuthority> CREATOR = new Creator<HealthAuthority>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public HealthAuthority createFromParcel(Parcel in) {
                return new HealthAuthority(in);
            }

            public HealthAuthority[] newArray(int size) {
                return (new HealthAuthority[size]);
            }

        };

        protected HealthAuthority(Parcel in) {
            this.hAuthorityId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.hAuthorityValue = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public HealthAuthority() {
        }

        /**
         * @param hAuthorityId
         * @param hAuthorityValue
         */
        public HealthAuthority(Integer hAuthorityId, String hAuthorityValue) {
            super();
            this.hAuthorityId = hAuthorityId;
            this.hAuthorityValue = hAuthorityValue;
        }

        public Integer getHAuthorityId() {
            return hAuthorityId;
        }

        public void setHAuthorityId(Integer hAuthorityId) {
            this.hAuthorityId = hAuthorityId;
        }

        public String getHAuthorityValue() {
            return hAuthorityValue;
        }

        public void setHAuthorityValue(String hAuthorityValue) {
            this.hAuthorityValue = hAuthorityValue;
        }
        public void setSelected(boolean isSelected){ this.isSelected = isSelected;}

        public boolean getSelected(){ return isSelected;}

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(hAuthorityId);
            dest.writeValue(hAuthorityValue);
        }

        public int describeContents() {
            return 0;
        }

    }


    public class NotificationPreference implements Parcelable {

        @SerializedName("PreferenceId")
        @Expose
        private Integer preferenceId;
        @SerializedName("PreferenceValue")
        @Expose
        private String preferenceValue;
        private boolean isSelected;
        public final  Parcelable.Creator<NotificationPreference> CREATOR = new Creator<NotificationPreference>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public NotificationPreference createFromParcel(Parcel in) {
                return new NotificationPreference(in);
            }

            public NotificationPreference[] newArray(int size) {
                return (new NotificationPreference[size]);
            }

        };

        protected NotificationPreference(Parcel in) {
            this.preferenceId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.preferenceValue = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public NotificationPreference() {
        }

        /**
         * @param preferenceValue
         * @param preferenceId
         */
        public NotificationPreference(Integer preferenceId, String preferenceValue) {
            super();
            this.preferenceId = preferenceId;
            this.preferenceValue = preferenceValue;
        }

        public Integer getPreferenceId() {
            return preferenceId;
        }

        public void setPreferenceId(Integer preferenceId) {
            this.preferenceId = preferenceId;
        }

        public String getPreferenceValue() {
            return preferenceValue;
        }

        public void setPreferenceValue(String preferenceValue) {
            this.preferenceValue = preferenceValue;
        }
        public void setSelected(boolean isSelected){ this.isSelected = isSelected;}

        public boolean getSelected(){ return isSelected;}

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(preferenceId);
            dest.writeValue(preferenceValue);
        }

        public int describeContents() {
            return 0;
        }

    }


    public class Region implements Parcelable {

        @SerializedName("RegionId")
        @Expose
        private Integer regionId;
        @SerializedName("RegionValue")
        @Expose
        private String regionValue;
        private boolean isSelected = false;
        public final Parcelable.Creator<Region> CREATOR = new Creator<Region>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Region createFromParcel(Parcel in) {
                return new Region(in);
            }

            public Region[] newArray(int size) {
                return (new Region[size]);
            }

        };

        protected Region(Parcel in) {
            this.regionId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.regionValue = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public Region() {
        }

        /**
         * @param regionValue
         * @param regionId
         */
        public Region(Integer regionId, String regionValue) {
            super();
            this.regionId = regionId;
            this.regionValue = regionValue;
        }

        public Integer getRegionId() {
            return regionId;
        }

        public void setRegionId(Integer regionId) {
            this.regionId = regionId;
        }

        public String getRegionValue() {
            return regionValue;
        }

        public void setRegionValue(String regionValue) {
            this.regionValue = regionValue;
        }

        public void setSelected(boolean isSelected){ this.isSelected = isSelected;}

        public boolean getSelected(){ return isSelected;}

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(regionId);
            dest.writeValue(regionValue);
        }

        public int describeContents() {
            return 0;
        }

    }

}











