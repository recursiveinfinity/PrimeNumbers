package com.example.primenumbers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

public class HomeFragment extends Fragment implements HomeContract.View {


    private PrimeNumbersAdapter primeNumbersAdapter = new PrimeNumbersAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prime_numbers, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnGetPrimeNumbers = view.findViewById(R.id.btnGetPrimeNumbers);
        RecyclerView recyclerView = view.findViewById(R.id.rvResults);
        final EditText etInput = view.findViewById(R.id.etNumber);

        final HomeContract.Presenter presenter = new HomePresenter(this);

        btnGetPrimeNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getPrimeNumbersInRange(etInput.getText().toString());
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                linearLayoutManager.getOrientation()));
        recyclerView.setAdapter(primeNumbersAdapter);
    }

    @Override
    public void showPrimeNumbers(List<Integer> primeNumbers) {
        primeNumbersAdapter.setData(primeNumbers);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
