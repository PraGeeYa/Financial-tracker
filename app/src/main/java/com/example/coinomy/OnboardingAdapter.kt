package com.example.coinomy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnboardingAdapter(private val activity: OnboardingActivity) : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    private val titles = listOf(
        "Welcome to Coinomy",
        "Track Your Expenses",
        "Manage Your Budget"
    )

    private val descriptions = listOf(
        "Your personal finance companion to help you manage your money better",
        "Easily track your daily expenses and income with just a few taps",
        "Set budgets and get insights to improve your financial health"
    )

    private val images = listOf(
        R.drawable.onboarding1,
        R.drawable.onboarding2,
        R.drawable.onboarding3
    )

    class OnboardingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.onboardingImage)
        val title: TextView = view.findViewById(R.id.onboardingTitle)
        val description: TextView = view.findViewById(R.id.onboardingDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_onboarding, parent, false)
        return OnboardingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.title.text = titles[position]
        holder.description.text = descriptions[position]
        holder.image.setImageResource(images[position])
    }

    override fun getItemCount(): Int = titles.size
} 