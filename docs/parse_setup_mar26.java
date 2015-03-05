try {
    ArrayList<Bike> fullBikeList = new ArrayList<>();
    Bike aBike = new Bike(1, "Liz", false);
    aBike.save();
    fullBikeList.add(aBike);
    aBike = new Bike(2, "Nicole Reed", false);
    aBike.save();
    fullBikeList.add(aBike);
    aBike = new Bike(3, "Nicole Paxton", false);
    aBike.save();
    fullBikeList.add(aBike);
    aBike = new Bike(4, "Caroline Ozer", false);
    aBike.save();
    fullBikeList.add(aBike);
    aBike = new Bike(5, "Dourov", false);
    aBike.save();
    fullBikeList.add(aBike);
    aBike = new Bike(6, "Erika Johns", false);
    aBike.save();
    fullBikeList.add(aBike);
    aBike = new Bike(7, "", true);
    aBike.save();
    fullBikeList.add(aBike);

    ArrayList<TimeSlot> newTimes = new ArrayList<>();

    ArrayList<Bike> newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    TimeSlot newTimeSlot = new TimeSlot("12 - 1 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("1 - 2 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("2 - 3 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("3 - 4 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("4 - 5 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("5 - 6 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("6 - 7 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("7 - 8 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("8 - 9 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("9 - 10 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("10 - 11 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newTimeSlot = new TimeSlot("11 am - 12 pm", fullBikeList, false);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    Day newDay = new Day("March 26th, 2015", newTimes);
    newDay.save();
    Log.i("PARSE SETUP", "March 26th, 2015 DONE!");
} catch (ParseException e) { }
